package demo.generic;

/**
 * @author xiongxianwei
 * 2020/6/1 0001
 */
public class GenericClass<X> {

    private X member;

    public GenericClass(X member) {
        this.member = member;
    }

    public X test(X target){
        return target;
    }

    public X getMember() {
        return member;
    }

    public void setMember(X member) {
        this.member = member;
    }
}
