package kaappo.monilista;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static int TYPE_NORMAL = 0;
    public static int TYPE_NORMAL_WITH_BUTTON = 1;


    private final List<Entry> entries;


    public ListAdapter (List<Entry> entries) {
        this.entries = entries;
    }

    @Override
    public int getItemViewType (int position) {
        String type = this.entries.get(position).getType();
        int temp;

        if (type.equals(Entry.ROW_NORMAL)) {
            temp = ListAdapter.TYPE_NORMAL;
        } else if (type.equals(Entry.ROW_NORMAL_WITH_BUTTON)) {
            temp = ListAdapter.TYPE_NORMAL_WITH_BUTTON;
        } else {
            temp = 0;
        }

        return temp;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        final LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());

        int layoutID;

        if (getItemViewType(position) == ListAdapter.TYPE_NORMAL) {
            final View v = layoutInflater.inflate(R.layout.layout_normal, viewGroup, false);
            return new Viewholders.ViewHolder(v);

        } else {
            final View v = layoutInflater.inflate(R.layout.layout_button, viewGroup, false);
            return new Viewholders.ViewHolderWithButton(v);
        }
    }

    @Override
    public void onBindViewHolder (RecyclerView.ViewHolder entryViewHolder, int index) {
        int viewType = getItemViewType(index);

        if (viewType == ListAdapter.TYPE_NORMAL) {
            ((Viewholders.ViewHolder) entryViewHolder).content.setText(this.entries.get(index).getContent());
            ((Viewholders.ViewHolder) entryViewHolder).wrapper.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
        } else if (viewType == ListAdapter.TYPE_NORMAL_WITH_BUTTON) {
            ((Viewholders.ViewHolderWithButton) entryViewHolder).content.setText(this.entries.get(index).getContent());
            ((Viewholders.ViewHolderWithButton) entryViewHolder).button.setText(this.entries.get(index).getButtonText());
            ((Viewholders.ViewHolderWithButton) entryViewHolder).wrapper.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;


        }
    }

    @Override
    public int getItemCount() {
        return this.entries.size();
    }
}
