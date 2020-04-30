package id.yongki.tugas3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private List<Mahasiswa> albumList;
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nama,nim,jurusan,alamat;
        public MyViewHolder(View v) {
            super(v);

            nama = (TextView)v.findViewById(R.id.tvNama);
            nim = (TextView)v.findViewById(R.id.tvNim);
            jurusan = (TextView)v.findViewById(R.id.tvJurusan);
            alamat = (TextView)v.findViewById(R.id.tvAlamat);
        }
    }
    public RecyclerAdapter(Context mContext, List<Mahasiswa> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_layout, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Mahasiswa album = albumList.get(position);
        holder.nama.setText(album.getNama());
        holder.nim.setText(album.getNim());
        holder.jurusan.setText(album.getJurusan());
        holder.alamat.setText(album.getNotlp());
    }
    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
