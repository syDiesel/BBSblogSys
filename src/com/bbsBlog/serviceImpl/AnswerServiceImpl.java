/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.AnswerDao;
import com.bbsBlog.entity.Answer;
import com.bbsBlog.service.AnswerService;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("answerService")
public class AnswerServiceImpl implements AnswerService {
	
	@Resource
	private AnswerDao answerDao;
	/**
	 * @return answerDao
	 */
	public AnswerDao getAnswerDao() {
		return answerDao;
	}

	/**
	 * @param answerDao 要设置的 answerDao
	 */
	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.AnswerService#saveAnswer(com.bbsBlog.entity.Answer)
	 */
	@Override
	public void saveAnswer(Answer answer) {
		 this.answerDao.saveAnswer(answer);
        
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.AnswerService#updateAnswer(com.bbsBlog.entity.Answer)
	 */
	@Override
	public void updateAnswer(Answer answer) {
         this.answerDao.updateAnswer(answer);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.AnswerService#deleteAnswer(long)
	 */
	@Override
	public void deleteAnswer(long id) {
    this.answerDao.deleteAnswer(id);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.AnswerService#listAnswer()
	 */
	@Override
	public List<Answer> listAnswer() {
		return  this.answerDao.listAnswer();
	}

	@Override
	public Answer findOneAnswer(long aId) {
		return   this.answerDao.findOneAnswer(aId);
	}

	@Override
	public List<Answer> findAnswer(long qId) {
		return   this.answerDao.findAnswer(qId);
	}

	@Override
	public List<Answer> findAnswerByReA(long aId) {
	
		return  this.answerDao.findAnswerByReId(aId);
	}

	@Override
	public List<Answer> findZhuiWen(long userInfoId, long zhuiId) {
		return this.answerDao.findZhuiWen(userInfoId, zhuiId);
	}
	
	public List<Answer> listAnswerBySql(String sql) {
		return this.answerDao.listAnswerBySql(sql);
	}

}
