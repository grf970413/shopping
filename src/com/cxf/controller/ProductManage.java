package com.cxf.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.cxf.dao.ProductDao;
import com.cxf.pojo.Product;
import com.cxf.pojo.Sort;
import com.cxf.pojo.TypeAndSort;
import com.cxf.service.ProductService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/ProductManage")
public class ProductManage {
	
	/**
	  *   产品管理页面
	 * @param
	 * @return
	 */
	@RequestMapping("/product-manage")
	public ModelAndView productManage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		try {	
			
			request.setCharacterEncoding("utf-8");
				List<TypeAndSort> typeAndSortList = new ArrayList<>();//产品类型及分类列表
				List<String> typeList = productService.getAllTypeName();//
				for (String typeName:typeList) {
					TypeAndSort t = new TypeAndSort();
					t.setTypeName(typeName);
					Integer typeId = productService.getTypeIdByTypeName(typeName);
					t.setSortList(productService.getSortListByTypeId(typeId));
					typeAndSortList.add(t);
				}
				//request.setAttribute("typeAndSortList", typeAndSortList);
				mv.addObject("typeAndSortList",typeAndSortList);
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
		if(null != request.getParameter("typeName")) {
			mv.addObject("typeName",request.getParameter("typeName"));
			mv.addObject("currentPage",Integer.parseInt(request.getParameter("currentPage")));
			Product product = productService.getProductByName(request.getParameter("productName"));
			mv.addObject("sortName",productService.getSortNameBySortId(product.getSortId()));
		} else {
			mv.addObject("typeName","0");
			mv.addObject("currentPage",1);
			mv.addObject("sortName","0");
		}
		mv.setViewName("admin/product-manage");
		return mv;
	}
	/**
	 * 添加产品页面
	 * @param
	 * @return
	 */
	@RequestMapping("/product-add")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		mv.addObject("typeList",productService.getAllTypeName()); //一级分类
		mv.setViewName("admin/product-add");
		return mv;
	}
	/**
	 * 删除产品
	 * @param
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		PrintWriter printWriter = response.getWriter();
		String productName = request.getParameter("productName");
		productService.deleteProduct(productName);
		printWriter.write("{\"res\":\"1\"}");
	}
	
	/**
	  *   更新产品页面
	 * @param
	 * @return
	 */
	@RequestMapping("/product-update")
	public ModelAndView updateProduct(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		Product product = productService.getProductByName(request.getParameter("productName"));
		mv.addObject("currentPage",Integer.parseInt(request.getParameter("currentPage")));
		mv.addObject("typeName",productService.getTypeNameByTypeId(productService.getTypeIdBySortId(product.getSortId())));//待续
		mv.addObject("typeList",productService.getAllTypeName());
		mv.addObject("price",product.getPrice());
		mv.addObject("productName",product.getProductName());
		mv.addObject("info",product.getInfo());
		//mv.addObject("refPrice",product.getRefPrice());
		mv.addObject("stock",product.getStock());
		mv.addObject("sortId",product.getSortId());
		mv.addObject("typeId",productService.getTypeIdBySortId(product.getSortId()));
		mv.setViewName("admin/product-update");
		return mv;
	}
	/**
	 * 更新产品信息
	 * @param
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/update")
	public void update(HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter printWriter = response.getWriter();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		//System.out.println(request.getParameter("product"));
		Product product = productService.getProductByName(request.getParameter("productName"));
		
		product.setSortId(productService.getSortIdBySortName(request.getParameter("sortName")));
		product.setProductName(request.getParameter("productName"));
		product.setInfo(request.getParameter("info"));
		product.setPrice(Float.parseFloat(request.getParameter("price")));
		//product.setRefPrice(Float.parseFloat(request.getParameter("refPrice")));
		product.setStock(Integer.parseInt(request.getParameter("stock")));
		//product.setSortId(productService.getSortIdBySortName(request.getParameter("sortName")));
		productService.updateProduct(product);
		
		
		
		printWriter.write("{\"res\":\"1\"}");
		printWriter.close();
	}
	/**
	 * 根据选中的类型返回分类列表
	 * @param
	 * @return
	 */
	@RequestMapping("/getSortListByTypeName")
	public void getSortListByTypeName(HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter printWriter = response.getWriter();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		
		Gson gson = new Gson();
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		
		//System.out.println(request.getParameter("typeName"));
		Integer typeId = productService.getTypeIdByTypeName(request.getParameter("typeName"));
		List<Sort> sortList = productService.getSortListByTypeId(typeId);
		//System.out.println(sortList.size());
		
		//printWriter.write("{\"res\":\"1\"}");
		printWriter.write(gson.toJson(sortList));
		printWriter.close();
	}
	/**
	 * 添加产品
	 * @param
	 * @return
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter printWriter = response.getWriter();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		if (null!=productService.getProductByName(request.getParameter("productName"))) { //判断产品是否已经存在
			printWriter.write("{\"res\":\"0\"}");
		} else {
			Product product = (Product)ctx.getBean("product"); //获取一个产品对象
			product.setSortId(productService.getSortIdBySortName(request.getParameter("sort"))); //分类ID
			product.setProductName(request.getParameter("productName")); //产品名称
			product.setPrice(Float.parseFloat(request.getParameter("price"))); //价格
			product.setStock(Integer.parseInt(request.getParameter("stock")));
			//product.setRefPrice(Float.parseFloat(request.getParameter("refPrice"))); //参考价格
			product.setInfo(request.getParameter("info")); //描述信息
			//product.setImgAddress(request.getParameter("imgAddress")); //图片的测试数据
			product.setImageAddress(request.getParameter("imgAddress"));
			//数据库操作
			productService.addProduct(product); //添加产品
			printWriter.write("{\"res\":\"1\"}");
		}
		printWriter.close();
	}
	@RequestMapping("/uploader")
	public void upload(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("收到图片");
		MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		MultipartHttpServletRequest Murequest = resolver.resolveMultipart(request);
		
		//MultipartHttpServletRequest Murequest = (MultipartHttpServletRequest)request;
        Map<String, MultipartFile> files = Murequest.getFileMap();//得到文件map对象
        String uploadUrl = request.getSession().getServletContext().getRealPath("/")+"res\\static\\img\\";//得到当前工程路径拼接上文件名
        //String uploadUrl = "C:\\Users\\Administrator\\Desktop\\test\\";
        File dir = new File(uploadUrl);
        int counter = 0;
        String fileName = null;
        File tagetFile;
        System.out.println(uploadUrl);
        if(!dir.exists())//目录不存在则创建
            dir.mkdirs();
        for(MultipartFile file :files.values()) {
            counter++;
            fileName=file.getOriginalFilename();
            tagetFile = new File(uploadUrl+fileName);//创建文件对象
            if(!tagetFile.exists()) {//文件名不存在 则新建文件，并将文件复制到新建文件中
                try {
                    tagetFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    file.transferTo(tagetFile);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("接收完毕");
	}
}