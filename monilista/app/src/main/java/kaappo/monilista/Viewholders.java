package kaappo.monilista;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class Viewholders {

    static class ViewHolderNewItem extends RecyclerView.ViewHolder {
        TextView body;
        TextView title;
        Button save;
        RelativeLayout wrapper;


        public ViewHolderNewItem (View v) {
            super(v);

            title = v.findViewById(R.id.title);
            body = v.findViewById(R.id.body);
            save = v.findViewById(R.id.save);
            wrapper = v.findViewById(R.id.wrapper);

        }
    }

    static class ViewHolderExistingItem extends RecyclerView.ViewHolder {
        TextView body;
        TextView title;
        Button delete;
        RelativeLayout wrapper;

        public ViewHolderExistingItem (View v) {
            super(v);

            title = v.findViewById(R.id.title);
            body = v.findViewById(R.id.body);
            delete = v.findViewById(R.id.delete);
            wrapper = v.findViewById(R.id.wrapper);


        }
    }
}
