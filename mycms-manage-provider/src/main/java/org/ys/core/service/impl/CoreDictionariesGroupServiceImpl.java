package org.ys.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ys.common.page.PageBean;
import org.ys.core.dao.CoreDictionariesGroupMapper;
import org.ys.core.model.CoreDictionariesGroup;
import org.ys.core.model.CoreDictionariesGroupExample;
import org.ys.core.service.CoreDictionariesGroupService;

import com.github.pagehelper.PageHelper;

@Service("coreDictionariesGroupService")
public class CoreDictionariesGroupServiceImpl implements CoreDictionariesGroupService {
	
	@Autowired
	private CoreDictionariesGroupMapper coreDictionariesGroupMapper;

	@Override
	public CoreDictionariesGroup queryCoreDictionariesGroupById(Long coreDictGroupId) throws Exception {
		if(null == coreDictGroupId) {
			return null;
		}
		return coreDictionariesGroupMapper.selectByPrimaryKey(coreDictGroupId);
	}

	@Override
	public void save(CoreDictionariesGroup coreDictionariesGroup) throws Exception {
		if(null != coreDictionariesGroup) {
			coreDictionariesGroupMapper.insert(coreDictionariesGroup);
		}
	}

	@Override
	public void updateById(CoreDictionariesGroup coreDictionariesGroup) throws Exception {
		if(null != coreDictionariesGroup && null != coreDictionariesGroup.getCoreDictGroupId()) {
			coreDictionariesGroupMapper.updateByPrimaryKey(coreDictionariesGroup);
		}
	}

	@Override
	public void updateByExaple(CoreDictionariesGroup coreDictionariesGroup, CoreDictionariesGroupExample example) throws Exception {
		if(null != coreDictionariesGroup && null != example) {
			coreDictionariesGroupMapper.updateByExample(coreDictionariesGroup, example);
		}
	}

	@Override
	public void delCoreDictionariesGroupById(Long coreDictGroupId) throws Exception {
		if(null != coreDictGroupId) {
			coreDictionariesGroupMapper.deleteByPrimaryKey(coreDictGroupId);
		}
	}

	@Override
	public List<CoreDictionariesGroup> queryCoreDictionariesGroupsByExample(CoreDictionariesGroupExample example) throws Exception {
		if(null == example) {
			return null;
		}
		return coreDictionariesGroupMapper.selectByExample(example);
	}

	@Override
	public PageBean<CoreDictionariesGroup> pageCoreDictionariesGroupsByExample(CoreDictionariesGroupExample example, int pageNum, int pageSize) throws Exception {
		if(null == example) {
			return null;
		}
		PageHelper.startPage(pageNum, pageSize, true);
		List<CoreDictionariesGroup> groupList = coreDictionariesGroupMapper.selectByExample(example);
		return new PageBean<CoreDictionariesGroup>(groupList);
	}

}
