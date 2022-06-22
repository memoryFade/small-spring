interface A {
    StringBuilder s = new StringBuilder("ok");
}

class B implements A {
}

class C implements A {
}

class Foo extends Exception {
    public Foo(String m) {
        super(m);
    }
}

class Bar extends Foo {
    public Bar(String m) {
        super(m);
    }
}

public class Test {
    public static String func() throws Exception {
        String ret = "dokey";
        try {
            B b = new B();
            C c = new C();
            c.s.append("ey");
            if (b.s.toString().equals("okey")) {
                throw new Foo("Foo");
            } else {
                throw new Bar("Bar");
            }
        } catch (Bar e) {
            System.out.println(e.getMessage());
            return ret;
        } catch (Foo e) {
            System.out.println(e.getMessage());
            return ret;
        } finally {
            System.out.println("hello");
            ret = "world";
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(func());
    }
}