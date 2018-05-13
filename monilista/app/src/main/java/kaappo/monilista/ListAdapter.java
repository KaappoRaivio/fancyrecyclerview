package kaappo.monilista;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        boolean real = !this.entries.get(position).isPlaceholder();

        if (real) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        final LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());

        int layoutID;

        if (getItemViewType(position) == 0) {
            final View v = layoutInflater.inflate(R.layout.item, viewGroup, false);
            return new Viewholders.ViewHolderExistingItem(v);

        } else {
            final View v = layoutInflater.inflate(R.layout.new_item, viewGroup, false);
            return new Viewholders.ViewHolderNewItem(v);
        }
    }

    @Override
    public void onBindViewHolder (RecyclerView.ViewHolder entryViewHolder, int index) {
        int viewType = getItemViewType(index);
        Entry current = this.entries.get(index);

        if (viewType == 0) {

            Viewholders.ViewHolderExistingItem vh = (Viewholders.ViewHolderExistingItem) entryViewHolder;

            vh.title.setText(current.getTitle());
            vh.body.setText(current.getContent());
            vh.delete.setTag(current.getID());

        } else if (viewType == 1) {
            Viewholders.ViewHolderNewItem vh = (Viewholders.ViewHolderNewItem) entryViewHolder;

            vh.save.setTag(current.getID());

        }
    }

    @Override
    public int getItemCount() {
        return this.entries.size();
    }

    public void newEntry (View v) {


    }
}
