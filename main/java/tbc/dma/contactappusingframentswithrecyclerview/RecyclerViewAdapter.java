package tbc.dma.contactappusingframentswithrecyclerview;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ContactViewHolder> {
    private Context context;
    private List<ContactList> cntList;
    private Dialog dgl;

    public RecyclerViewAdapter(Context context, List<ContactList> data)
    {
        this.context = context;
        this.cntList = data;
    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_contact, parent, false);
        final ContactViewHolder vHolder = new ContactViewHolder(view);

        dgl = new Dialog(context);
        dgl.setContentView(R.layout.contactdialogbox);

        vHolder.contactItemLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dg_name = dgl.findViewById(R.id.diag_contactName);
                TextView dg_number = dgl.findViewById(R.id.diag_phoneNumber);
                ImageView dg_img = dgl.findViewById(R.id.diag_image);

                dg_name.setText(cntList.get(vHolder.getAdapterPosition()).getName());
                dg_number.setText(cntList.get(vHolder.getAdapterPosition()).getNumber());
                dg_img.setImageResource(cntList.get(vHolder.getAdapterPosition()).getImage());
                //Toast.makeText(context, "You CLicked: "+ vHolder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
                dgl.show();
            }
        });
        return vHolder ;
    }
    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.textViewName.setText(cntList.get(position).getName());
        holder.textViewNumber.setText(cntList.get(position).getNumber());
        holder.image.setImageResource(cntList.get(position).getImage());
    }
    @Override
    public int getItemCount() {
        return cntList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private LinearLayout contactItemLinearLayout;
        private TextView   textViewNumber;
        private ImageView image;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            contactItemLinearLayout = itemView.findViewById(R.id.LinearLayoutContactItem);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewNumber = itemView.findViewById(R.id.textViewNumber);
            image = itemView.findViewById(R.id.img_contact);
        }
    }
}
