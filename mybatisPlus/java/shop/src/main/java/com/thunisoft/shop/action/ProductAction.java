package com.thunisoft.shop.action;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.thunisoft.shop.domain.Product;
import com.thunisoft.shop.domain.query.PageQuery;
import com.thunisoft.shop.domain.query.ProductQuery;
import com.thunisoft.shop.service.IFtpService;
import com.thunisoft.shop.service.IProductDirService;
import com.thunisoft.shop.service.IProductService;
import com.thunisoft.shop.utils.Global;
import com.thunisoft.shop.utils.PropertiesUtil;
import com.thunisoft.shop.utils.ftppool.FtpClientPool;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * 表现层，商品控制.
 * @author ljw on 2017-9-8下午2:22:14
 */
public class ProductAction extends ActionSupport {

    /**序列化编号.*/
    private static final long serialVersionUID = -8207679234018919543L;
    
    /** 日志组件. */
    private static final Logger logger = LoggerFactory
            .getLogger(ProductAction.class);

    /** 注入productService. */
    @Resource
    private IProductService productService;

    /** 注入productDirService. */
    @Resource
    private IProductDirService productDirService;

    /**注入ftpService*/
    @Resource
    private IFtpService ftpService;

    /** 界面获取用户信息. */
    private Product product;

    /**上传文件，对应页面  s:file name="pic"*/
    private File pic;

    /**上传文件的原始名称*/
    private String picFileName;

    /**查询对象*/
    private ProductQuery productQuery = new ProductQuery();

    /**获取config配置*/
    private PropertiesUtil propertiesUtil = new PropertiesUtil("config.properties");

    /**
     * 导向方法.
     * @return String 结果名字
     */
    @Override
    public String execute() throws Exception {
        return ActionSupport.SUCCESS;
    }

    /**
     * 表单验证.
     * 方法名字可以指定验证指定方法
     */
    public void validateSave() {
        if (StringUtils.isBlank(product.getName())) {
            addFieldError("productname_error", "商品名不能为空");
        }
    }

    /**
     * 新增跳转.
     * @return String 结果名字
     * @throws Exception 异常
     */
    @Override
    public String input() throws Exception {
        ActionContext.getContext().put("dirList",
            productDirService.findIdAndName());
        return ActionSupport.INPUT;
    }

    /**
     * 修改跳转.
     * @return String 结果名字
     * @throws Exception 异常
     */
    public String update() throws Exception {
        Long id = product.getId();
        if (id != null) {
            product = productService.getById(id);
        }
        ActionContext.getContext().put("dirList",
            productDirService.findIdAndName());
        return ActionSupport.INPUT;
    }

    /**
     * 保存跳转.
     * @return String 结果名字
     * @throws Exception 异常
     */
    @InputConfig(methodName = "input")
    public String save() throws Exception {
        if (product.getId() == null) {
            FTPClient ftpClient = null;
            String filePathAndName = null;
            String miniFilePathAndName = null;
            try {
                ftpClient = FtpClientPool.borrowObject();
                filePathAndName = ftpService.upLoadTmpFile(pic,picFileName,ftpClient);
                miniFilePathAndName = ftpService.uploadSmallFile(pic,filePathAndName,ftpClient);
            } catch (Exception e) {
                throw new Exception(e);
            } finally {
                FtpClientPool.returnObject(ftpClient);
            }

            product.setBigPic(filePathAndName);
            product.setSmallPic(miniFilePathAndName);
            productService.save(product);
        } else {
            productService.update(product);
        }
        return ActionSupport.SUCCESS;
    }


    /**
     * 删除跳转.
     * @return String 结果名字
     * @throws Exception
     */
    public String delete() throws Exception {
        productService.delete(product.getId());
        return ActionSupport.SUCCESS;
    }

    /**
     * 用户列表.
     * @return String 结果名字
     */
    public String list() throws Exception {
        PageQuery pageQuery = productQuery.getPageQuery();
        Integer currentPage = pageQuery.getCurrentPage();
        Integer pageSize = pageQuery.getPageSize();
        
        PageHelper.startPage(currentPage-1, pageSize);
        List<Product> productList = productService.getByQuery(productQuery);
        PageInfo<Product> pageInfo = new PageInfo<Product>(productList);
        //获取总记录数
        Long total = pageInfo.getTotal();
        pageQuery.setCurrentValue(currentPage, pageSize, total.intValue());

        String download = "/resource/download";
        String downloadPath = ServletActionContext.getServletContext().getRealPath(download);
        String contextShowPath = ServletActionContext.getRequest().getContextPath() + File.separator + download;
        
      //开发阶段不连接ftp
//        productService.downProductImage(productList,downloadPath,contextShowPath);


        ActionContext.getContext().put("productList", productList);
        ActionContext.getContext().put("dirList",productDirService.findIdAndName());
        return Global.LIST;
    }

    //===================前台往后台传值====================
    public void setPic(File pic) {
        this.pic = pic;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public void setPicFileName(String picFileName) {
        this.picFileName = picFileName;
    }

    public void setProductQuery(ProductQuery productQuery) {
        this.productQuery = productQuery;
    }

    //===================后台往前台传值====================


    public Product getProduct() {
        return product;
    }

    public File getPic() {
        return pic;
    }

    public ProductQuery getProductQuery() {
        return productQuery;
    }



}
