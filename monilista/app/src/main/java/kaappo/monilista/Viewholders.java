package kaappo.monilista;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class Viewholders {

    static class ViewHolderWithButton extends RecyclerView.ViewHolder {
        Button button;
        TextView content;
        RelativeLayout wrapper;


        public ViewHolderWithButton (View v) {
            super(v);

            button = v.findViewById(R.id.button);
            content = v.findViewById(R.id.content);
            wrapper = v.findViewById(R.id.wrapper);

        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView content;
        RelativeLayout wrapper;

        public ViewHolder (View v) {
            super(v);

            content = v.findViewById(R.id.content);
            wrapper = v.findViewById(R.id.wrapper);


        }
    }
}
