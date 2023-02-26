package orhan.yusuf.bayrakquiz.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import orhan.yusuf.bayrakquiz.databinding.SonucEkraniFragmentBinding;

public class SonucEkranıFragment extends Fragment {
    int dogru,yanlis;
    SonucEkraniFragmentBinding binding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SonucEkraniFragmentBinding.inflate(getLayoutInflater());
        if (getArguments() != null){
            dogru = SonucEkranıFragmentArgs.fromBundle(getArguments()).getDogruSayisi();
            yanlis = SonucEkranıFragmentArgs.fromBundle(getArguments()).getYanlisSayisi();
            binding.dgrYnlsText.setText(dogru+" Doğru | "+yanlis+" Yanlış");
            int yüzde = (dogru * 100) / 10;
            binding.basariOraniText.setText("% "+yüzde+" BAŞARI");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnTekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Yeniden Başlat
                NavDirections action = SonucEkranıFragmentDirections.actionSonucEkranıFragmentToAnaFragment();
                Navigation.findNavController(view).navigate(action);
                Intent intent = new Intent();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });
    }
}
