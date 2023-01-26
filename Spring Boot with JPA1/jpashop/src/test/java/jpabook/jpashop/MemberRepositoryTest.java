package jpabook.jpashop;

import static org.assertj.core.api.Assertions.assertThat;  //자동 import되지 않음

import javax.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

//@RunWith(SpringRunner.class)
//@RunWith의 경우 Junit4에서 스프링 테스트 시에 필요한 어노테이션이였으나 Junit5에서는 생략이 가능합니다. 라는 말듣고 과감히 생략
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;
    @Autowired EntityManager em;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() throws Exception{
        //given
//        ctrl + alt + v
        Member member = new Member();
        member.setName("memberA");

        //when
        Long saveId = memberService.join(member);
        Member findMember = memberRepository.findOne(saveId);

        //then
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getName()).isEqualTo(member.getName());
        assertThat(findMember).isEqualTo(member);
        System.out.println("findMember == member "+ (findMember == member));
    }

}