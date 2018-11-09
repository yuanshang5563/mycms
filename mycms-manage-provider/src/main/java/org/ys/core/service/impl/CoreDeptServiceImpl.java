package org.ys.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ys.common.page.PageBean;
import org.ys.core.dao.CoreDeptMapper;
import org.ys.core.model.CoreDept;
import org.ys.core.model.CoreDeptExample;
import org.ys.core.service.CoreDeptService;

import com.github.pagehelper.PageHelper;

@Service("coreDeptService")
public class CoreDeptServiceImpl implements CoreDeptService {
	@Autowired
	private CoreDeptMapper coreDeptMapper;

	@Override
	public CoreDept queryCoreDeptById(Long coreDeptId) throws Exception {
		if(null == coreDeptId) {
			return null;
		}
		return coreDeptMapper.selectByPrimaryKey(coreDeptId);
	}

	@Override
	public void save(CoreDept coreDept) throws Exception {
		if(null != coreDept) {
			coreDeptMapper.insert(coreDept);
		}
	}

	@Override
	public void updateById(CoreDept coreDept) throws Exception {
		if(null != coreDept) {
			coreDeptMapper.updateByPrimaryKey(coreDept);
		}
	}

	@Override
	public void updateByExaple(CoreDept coreDept, CoreDeptExample example) throws Exception {
		if(null != coreDept && null != example) {
			coreDeptMapper.updateByExample(coreDept, example);
		}
	}

	@Override
	public void delCoreDeptById(Long coreDeptId) throws Exception {
		if(null != coreDeptId) {
			coreDeptMapper.deleteByPrimaryKey(coreDeptId);
		}
	}

	@Override
	public List<CoreDept> queryCoreDeptsByExample(CoreDeptExample example) throws Exception {
		if(null == example) {
			return null;
		}
		return coreDeptMapper.selectByExample(example);
	}

	@Override
	public PageBean<CoreDept> pageCoreDeptsByExample(CoreDeptExample example, int pageNum, int pageSize) throws Exception {
		if(null == example) {
			return null;
		}
		PageHelper.startPage(pageNum, pageSize, true);
		List<CoreDept> deptList = coreDeptMapper.selectByExample(example);
		return new PageBean<CoreDept>(deptList);
	}

}
