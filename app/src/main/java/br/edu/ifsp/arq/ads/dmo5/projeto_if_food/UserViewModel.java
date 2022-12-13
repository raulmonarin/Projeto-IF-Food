package br.edu.ifsp.arq.ads.dmo5.projeto_if_food;

import android.annotation.SuppressLint;
import android.app.Application;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Optional;

import br.edu.ifsp.arq.ads.dmo5.projeto_if_food.Model.UserModal;


public class UserViewModel extends AndroidViewModel {

    public static final String USER_ID = "USER_ID";

    private UserRep usersRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);
        this.usersRepository = new UserRep(application);
    }

    public void createUser(UserModal user) {
        usersRepository.createUser(user);
    }

    public void updateUser(UserModal user) {
        usersRepository.update(user);
    }

    public LiveData<UserModal> login(String email, String password) {
        return usersRepository.login(email, password);
    }

    public void logout() {
        PreferenceManager.getDefaultSharedPreferences(getApplication())
                .edit()
                .remove(USER_ID)
                .apply();
    }

    @SuppressLint("NewApi")
    public LiveData<UserModal> isLogged() {
        Optional<String> id = Optional.ofNullable(
                PreferenceManager.getDefaultSharedPreferences(getApplication())
                        .getString(USER_ID, null)
        );
        if (!id.isPresent()) {
            return new MutableLiveData<>(null);
        }
        return usersRepository.loadUser(id.get());
    }

    public void resetPassword(String email) {
        usersRepository.resetPassword(email);
    }

}