package orhan.yusuf.bayrakquiz.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import java.io.IOException;

import orhan.yusuf.bayrakquiz.Database.DatabaseCopyHelper;
import orhan.yusuf.bayrakquiz.databinding.AnaFragmentBinding;

public class AnaFragment extends Fragment {
    AnaFragmentBinding anaFragmentBinding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        anaFragmentBinding = AnaFragmentBinding.inflate(getLayoutInflater());
        databasecopy();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return anaFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anaFragmentBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections action = AnaFragmentDirections.actionAnaFragmentToSoruEkranıFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
    }
    public void databasecopy(){
        DatabaseCopyHelper helper = new DatabaseCopyHelper(getContext());
        try {
            helper.createDataBase();
        } catch (IOException e) {
           e.printStackTrace();
        }
        helper.openDataBase();
    }
}
