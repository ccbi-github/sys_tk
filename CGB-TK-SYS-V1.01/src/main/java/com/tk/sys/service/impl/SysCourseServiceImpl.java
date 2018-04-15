package com.tk.sys.service.impl;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tk.common.utils.ExportExcel;
import com.tk.common.vo.PageObject;
import com.tk.sys.common.exception.ServiceException;
import com.tk.sys.dao.SysCourseDao;
import com.tk.sys.entity.SysCourse;
import com.tk.sys.service.SysCourseService;
@Service
public class SysCourseServiceImpl implements SysCourseService{
	@Autowired
	private SysCourseDao sysCourseDao;
	@Override
	public PageInfo findPageObjects(String name, Integer pageNum) {
		//判断参数是否合理
		if(pageNum==null || pageNum<=0)
			throw new ServiceException("参数不合法");
		//使用pageInfo分页功能
		PageInfo info = null;
		try {//如果出现的是其他问题，将其catch并通知相关人员及时处理
			PageHelper.startPage(pageNum,5);
			List<SysCourse> list = sysCourseDao.findPageObjects(name);
			info = new PageInfo<>(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("系统错误");
		}
		
		return info;
	}
	@Override
	public int deleteObjects(String ids) {
		//判断传来的id是否为null或者为空值
		if(StringUtils.isEmpty(ids))
			throw new ServiceException("要删除的课程id不能为空");
		int row = 0;
		try {//如果出现的是其他问题，将其catch并通知相关人员及时处理
			//传来的id(可能有多个id)值为用逗号隔开的字符串，调用split方法转换成数组
			row = sysCourseDao.deleteObjects(ids.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("系统错误");
		}
		return row;
	}
	@Override
	public int insertObject(SysCourse entity) {
		//判断参数的合理性
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("您要保存的课程名不能为空");
		if(entity.getPrice()<0)
			throw new ServiceException("您要保存的课程的价格值，不合理");
		int row = 0;
		try {
			row = sysCourseDao.insertObject(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("系统错误");
		}

		return row;
	}
	@Override
	public int updateObjectById(SysCourse entity) {
		//判断参数是否合理
		if(entity.getId()==null || entity.getId()<=0){
			System.out.println("选择课程id参数不合法,课程id= "+entity.getId());
			throw new ServiceException("选择课程id参数不合法,课程id= "+entity.getId());}
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("您要保存的课程名不能为空");
		if(entity.getPrice()<0)
			throw new ServiceException("您要保存的课程的价格值，不合理");
		int row = 0;
		try {
			row = sysCourseDao.updateObjectById(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("系统错误");
		}
		return row;
	}
	@Override
	public SysCourse findObjectById(Integer id) {
		if(id==null||id<=0)
			throw new ServiceException("输入的参数id不合法");
		SysCourse entity = null;
		try {
			entity = sysCourseDao.findObjectById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("系统错误");
		}
		return entity;
	}
	@Override
	public int changeStateById(Integer id, Integer state, String modifiedUser) {
		if(id==null||id<=0)
			throw new ServiceException("输入的参数id不合法");
		if(state!=0&&state!=1)
			throw new ServiceException("输入的参数state不合法");
		int row = 0;
		try {
			row = sysCourseDao.changeObjectStateById(id, state, modifiedUser);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("系统错误");
		}
		return row;
	}
	@Override
	public void exportCourses() {
		String path="com.tk.sys.entity.SysCourse";
		List<SysCourse> list = sysCourseDao.findAllObject();
		ExportExcel ee = new ExportExcel(list,path);
		ee.toExcel();
	}
	
	/**ccb**/
	@Override
	public PageObject findObjectPagesByType(Integer pageCurrent, Integer type,String name) {
	    if(pageCurrent==null||pageCurrent<1){
	    	throw new ServiceException("参数不合法pageCurrent= "+pageCurrent);
	    }
	    if(!StringUtils.isEmpty(name)){
			try {
				byte []bytes=name.getBytes("iso-8859-1");
				name=new String(bytes, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	    int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		int rowCount=sysCourseDao.findRowCount(type,name);//
		List<SysCourse>records=sysCourseDao.findObjectPagesByType(startIndex,pageSize,type,name);
		PageObject pageObject =new PageObject();
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRecords(records);
		pageObject.setRowCount(rowCount);
		return pageObject;
	}
	@Override
	public void changeStateByIds(String  ids, Integer state, String modifiedUser) {
		if(StringUtils.isEmpty(ids))
			throw new ServiceException("输入的参数id不合法");
		if(state!=0&&state!=1)
			throw new ServiceException("输入的参数state不合法");
		
		int row = 0;
		try {
			row = sysCourseDao.changeObjectStateByIds(ids.split(","), state, modifiedUser);
			System.out.println("row= "+row);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("系统错误");
		}
		//return row;
		
	}
 

}
