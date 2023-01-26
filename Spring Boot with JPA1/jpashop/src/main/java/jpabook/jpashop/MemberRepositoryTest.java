package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryTest {
    @PersistenceContext
    private EntityManager em;

//    ctrl + shift + t : test코드 생성 단축키
    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }

}
