package com.plumbum.aapu.household.Cursors;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.plumbum.aapu.household.Image.ImageConvertor;
import com.plumbum.aapu.household.Implementaion.CategoryImplementation;
import com.plumbum.aapu.household.R;

/**
 * Created by Dawn on 6/26/2016.
 */
public class CategoryActivityCursor extends CursorAdapter {


    CategoryImplementation categoryImplementation=null;

    /**
     * Recommended constructor.
     *
     * @param context The context
     * @param c       The cursor from which to get the data.
     * @param flags   Flags used to determine the behavior of the adapter; may
     *                be any combination of {@link #FLAG_AUTO_REQUERY} and
     *                {@link #FLAG_REGISTER_CONTENT_OBSERVER}.
     */
    public CategoryActivityCursor(Context context, Cursor c, int flags) {
        super(context, c, 0);
    }

    /**
     * Makes a new view to hold the data pointed to by cursor.
     *
     * @param context Interface to application's global information
     * @param cursor  The cursor from which to get the data. The cursor is already
     *                moved to the correct position.
     * @param parent  The parent to which the new view is attached to
     * @return the newly created view.
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.category_list_card_view, parent, false);
    }


    /**
     * Bind an existing view to the data pointed to by cursor
     *
     * @param view    Existing view, returned earlier by newView
     * @param context Interface to application's global information
     * @param cursor  The cursor from which to get the data. The cursor is already
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor)
    {
        final ImageConvertor imageConvertor = new ImageConvertor(context);

        TextView textView = (TextView) view.findViewById(R.id.category_list_card_view_category_name);
        ImageView imageView = (ImageView) view.findViewById(R.id.category_list_card_view_category_icon);

        byte[] images = cursor.getBlob(cursor.getColumnIndexOrThrow("CATEGORY_ICON"));
        Bitmap bitmap = imageConvertor.convertByteInImage(images);

        textView.setText(cursor.getString(cursor.getColumnIndexOrThrow("CATEGORY_NAME")));
        imageView.setImageBitmap(bitmap);

    }
}
