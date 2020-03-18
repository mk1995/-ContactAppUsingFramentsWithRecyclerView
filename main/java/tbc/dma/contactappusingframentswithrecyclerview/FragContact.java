package tbc.dma.contactappusingframentswithrecyclerview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragContact extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private List<ContactList> contactLists;

    public FragContact() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactLists = new ArrayList<>();
        contactLists.add(new ContactList("Manoj Karki", "98987859875", R.drawable.ic_face_black_24dp));
        contactLists.add(new ContactList("Niraj Subedi", "9855559875", R.drawable.ic_face_black_24dp));
        contactLists.add(new ContactList("Nischal Adhikari", "9847058585", R.drawable.ic_launcher_foreground));
        contactLists.add(new ContactList("Saroj Neupane", "9840990975", R.drawable.ic_face_black_24dp));
        contactLists.add(new ContactList("Manoj Shitaula", "9845629875", R.drawable.ic_launcher_foreground));
        contactLists.add(new ContactList("Hari Niroula", "9841200875", R.drawable.ic_face_black_24dp));
        contactLists.add(new ContactList("Manu Karki", "9847059815", R.drawable.ic_face_black_24dp));
        contactLists.add(new ContactList("Neeta Sharma", "9847059875", R.drawable.ic_face_black_24dp));
        contactLists.add(new ContactList("Nitusha Regmi", "9847059505", R.drawable.ic_launcher_foreground));
        contactLists.add(new ContactList("Hanuman Chalise", "9847566875", R.drawable.ic_face_black_24dp));
        contactLists.add(new ContactList("Chintey Prasad", "98470593415", R.drawable.ic_launcher_foreground));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_frag_contact, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewContactList);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), contactLists);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }
}
