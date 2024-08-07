package toy.withme58.db.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import toy.withme58.db.member.enums.MemberStatus;
import toy.withme58.db.memberfriend.MemberFriendEntity;
import toy.withme58.db.memberquestion.MemberQuestionEntity;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name ="member")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length =50, nullable =false)
    @Email
    private String email;

    @Column(length =50, nullable =false)
    private String password;

    @Column(length =50, nullable =false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @BatchSize(size = 100)
    @OneToMany(mappedBy = "member")
    private List<MemberFriendEntity> memberFriendList = List.of();

    @BatchSize(size = 100)
    @OneToMany(mappedBy = "member")
    private List<MemberQuestionEntity> memberQuestionList = List.of();

}
