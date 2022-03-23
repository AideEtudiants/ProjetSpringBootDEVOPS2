package projet.studenity.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.studenity.model.Answer;
import projet.studenity.model.Forum;
import projet.studenity.repository.AnswerRepository;
import projet.studenity.repository.ForumRepository;
import projet.studenity.service.ForumAnswerService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ForumAnswerServiceImpl implements ForumAnswerService {
    @Autowired
    private ForumRepository forumRepo;

    @Autowired
    AnswerRepository answerRepo;

    @Override
    public Forum findForumById(int idForum) {
        List<Forum> forums = forumRepo.findAll();
        for(Forum forum: forums){
            if(forum.getId()==idForum){
                return forum;
            }
        }
        return null;
    }

    @Override
    public Answer findAnswerById(int idAnswer) {
        List<Answer> answers = answerRepo.findAll();
        for(Answer answer: answers){
            if(answer.getId()==idAnswer){
                return answer;
            }
        }
        return null;
    }

    @Override
    public boolean addForum(Forum forum) {
        try {
            long millis=System.currentTimeMillis();
            java.sql.Date date=new java.sql.Date(millis);
            forum.setStartDate(date);
            forumRepo.save(forum);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean addAnswerToForum(Answer answer) {
        try {
            long millis=System.currentTimeMillis();
            java.sql.Date date=new java.sql.Date(millis);
            answer.setStartDate(date);
            if(answer.getAnswer().equalsIgnoreCase("")){return false;}
            answerRepo.save(answer);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteForum(Forum forum) {
        try {
            forumRepo.delete(forum);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteAnswer(Answer answer) {
        try {
            answerRepo.delete(answer);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateForum(Forum forum) {
        try {
            forumRepo.save(forum);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAnswer(Answer answer) {
        try {
            answerRepo.save(answer);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<Forum> getAllForums() {
        return forumRepo.findAll();
    }

    @Override
    public List<Answer> listAnswerByForum(int idForum) {
        List<Answer> answers = answerRepo.findAll();
        List<Answer> answerList = new ArrayList<>();
        for(Answer answer: answers){
            if(answer.getIdForum()==idForum)
            answerList.add(answer);
        }
        return answerList;
    }
}
