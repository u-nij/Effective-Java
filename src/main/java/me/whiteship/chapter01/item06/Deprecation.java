package me.whiteship.chapter01.item06;

public class Deprecation {

    /**
     * @deprecated in favor of
     * {@link #Deprecation(String)}
     */
    /*
    컴파일 시간에 @Deprecated를 처리하는 어노테이션 프로세서를 통해
    컴파일 경고 메세지를 보내준다.

    forRemoval; 삭제될 코드임을 알려줄 수 있음.
    since; 배포될 버전을 명시할 수 있음.
     */
    @Deprecated(forRemoval = true, since = "1.2")
    public Deprecation() {
    }

    private String name;

    public Deprecation(String name) {
        this.name = name;
    }
}
