package orhan.yusuf.bayrakquiz.Database;

public class Bayraklar {
    private String bayrak_adi;
    private String bayrak_resim;
    private int bayrak_id;

    public Bayraklar() {
    }

    public Bayraklar(String bayrak_adi, String bayrak_resim, int bayrak_id) {
        this.bayrak_adi = bayrak_adi;
        this.bayrak_resim = bayrak_resim;
        this.bayrak_id = bayrak_id;
    }

    public String getBayrak_adi() {
        return bayrak_adi;
    }

    public void setBayrak_adi(String bayrak_adi) {
        this.bayrak_adi = bayrak_adi;
    }

    public String getBayrak_resim() {
        return bayrak_resim;
    }

    public void setBayrak_resim(String bayrak_resim) {
        this.bayrak_resim = bayrak_resim;
    }

    public int getBayrak_id() {
        return bayrak_id;
    }

    public void setBayrak_id(int bayrak_id) {
        this.bayrak_id = bayrak_id;
    }
}
