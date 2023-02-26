package orhan.yusuf.bayrakquiz.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

import orhan.yusuf.bayrakquiz.Database.Bayraklar;
import orhan.yusuf.bayrakquiz.Database.BayraklarDao;
import orhan.yusuf.bayrakquiz.Database.DataBase;
import orhan.yusuf.bayrakquiz.Fragment.SoruEkranıFragmentDirections;
import orhan.yusuf.bayrakquiz.R;
import orhan.yusuf.bayrakquiz.databinding.SoruEkraniFragmentBinding;

public class SoruEkranıFragment extends Fragment{
    ArrayList<Bayraklar> sorular;
    ArrayList<Bayraklar> yanlis_sorular;
    Bayraklar dogru_soru;
    DataBase dataBase;
    int dogru_sayisi = 0;
    int yanlis_sayisi = 0;
    int soru_sayisi = 0;
    HashSet<Bayraklar> hashSet;
    ArrayList<Bayraklar> secenekler;
    SoruEkraniFragmentBinding binding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SoruEkraniFragmentBinding.inflate(getLayoutInflater());
        dataBase = new DataBase(getContext());
        sorular = new BayraklarDao().random5(dataBase);
        hashSet = new HashSet<>();
        secenekler = new ArrayList<>();
        soru_yükle1();
        binding.buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dogru_kontrol(binding.buttonA);
                sayac_kontrol(view);

            }
        });
        binding.buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dogru_kontrol(binding.buttonB);
                sayac_kontrol(view);
            }
        });
        binding.buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dogru_kontrol(binding.buttonC);
                sayac_kontrol(view);
            }
        });
        binding.buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dogru_kontrol(binding.buttonD);
                sayac_kontrol(view);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public void soru_yükle1(){
        int s = soru_sayisi + 1;
        binding.soruSayisiText.setText((soru_sayisi+1)+" . SORU");
        dogru_soru = sorular.get(soru_sayisi);
        yanlis_sorular = new BayraklarDao().random_yanlis3(dataBase,dogru_soru.getBayrak_id());
        binding.bayrakImage.setImageResource(getResources().getIdentifier(dogru_soru.getBayrak_resim(),"drawable",getActivity().getPackageName()));
        hashSet.clear();
        hashSet.add(dogru_soru);
        hashSet.add(yanlis_sorular.get(0));
        hashSet.add(yanlis_sorular.get(1));
        hashSet.add(yanlis_sorular.get(2));
        secenekler.clear();
        for (Bayraklar b : hashSet){
            secenekler.add(b);
        }
        binding.buttonA.setText(secenekler.get(0).getBayrak_adi());
        binding.buttonB.setText(secenekler.get(1).getBayrak_adi());
        binding.buttonC.setText(secenekler.get(2).getBayrak_adi());
        binding.buttonD.setText(secenekler.get(3).getBayrak_adi());
    }
    public void dogru_kontrol(Button b){
        String buttonYazi = b.getText().toString();
        String dogru_cevap = dogru_soru.getBayrak_adi();
        if (buttonYazi.equals(dogru_cevap)){
            dogru_sayisi++;
        }else{
            Toast.makeText(getContext(), dogru_cevap,Toast.LENGTH_SHORT).show();
            yanlis_sayisi++;
        }
        binding.dogruText.setText(dogru_sayisi+" Doğru");
        binding.yanlisText.setText(yanlis_sayisi+" Yanlış");
    }
    public void sayac_kontrol(View view){
        soru_sayisi++;
        if (soru_sayisi != 10){
            soru_yükle1();
        }
        else{
            SoruEkranıFragmentDirections.ActionSoruEkranıFragmentToSonucEkranıFragment action = SoruEkranıFragmentDirections.actionSoruEkranıFragmentToSonucEkranıFragment();
            action.setDogruSayisi(dogru_sayisi);
            action.setYanlisSayisi(yanlis_sayisi);
            Navigation.findNavController(view).navigate(action);
        }
    }
}
