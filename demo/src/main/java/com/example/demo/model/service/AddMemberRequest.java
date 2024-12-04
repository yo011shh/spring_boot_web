package com.example.demo.model.service;
import jakarta.validation.constraints.*; // 검증 어노테이션 가져오기
import lombok.*;
import com.example.demo.model.domain.Member;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddMemberRequest {

    @NotBlank(message = "이름은 공백일 수 없습니다.") // 공백과 특수문자 허용 안 함
    @Pattern(regexp = "^[a-zA-Z가-힣0-9]+$", message = "이름은 특수문자를 포함할 수 없습니다.")
    private String name;

    @NotBlank(message = "이메일은 필수 입력 항목입니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.") // 이메일 형식 검증
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$",
        message = "비밀번호는 최소 8자 이상이어야 하며, 대문자와 숫자를 포함해야 합니다."
    )
    private String password;

    @NotBlank(message = "나이는 필수 입력 항목입니다.")
    @Pattern(regexp = "^(1[8-9]|[2-8][0-9]|90)$", message = "나이는 19세 이상 90세 이하만 허용됩니다.")
    private String age;

    @NotBlank(message = "휴대폰 번호는 필수 입력 항목입니다.")
    @Pattern(
        regexp = "^(010|011|016|017|018|019)-?\\d{3,4}-?\\d{4}$",
        message = "올바른 휴대폰 번호 형식이어야 합니다. 예: 010-1234-5678"
    )
    private String mobile;

    @NotBlank(message = "주소는 공백일 수 없습니다.")
    private String address;

    // Member 엔티티 변환 메서드
    public Member toEntity() {
        return Member.builder()
            .name(name)
            .email(email)
            .password(password)
            .age(age)
            .mobile(mobile)
            .address(address)
            .build();
    }
}
