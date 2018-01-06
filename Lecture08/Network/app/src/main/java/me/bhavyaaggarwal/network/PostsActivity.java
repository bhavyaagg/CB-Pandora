package me.bhavyaaggarwal.network;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import me.bhavyaaggarwal.network.models.Post;

public class PostsActivity extends AppCompatActivity {
    ListView lvPosts;
    ArrayList<Post> postArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        lvPosts = findViewById(R.id.lvPosts);
    }

    class PostAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return postArrayList.size();
        }

        @Override
        public Post getItem(int position) {
            return postArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(
                        android.R.layout.simple_list_item_2,
                        parent,
                        false);
            }

            Post post = getItem(position);

            ((TextView) convertView.findViewById(android.R.id.text1)).setText(post.getTitle());
            ((TextView) convertView.findViewById(android.R.id.text2)).setText(post.getBody());

            return null;
        }
    }

    public class DownloadPosts extends AsyncTask<Void, Void, ArrayList<Post>> {

        @Override
        protected ArrayList<Post> doInBackground(Void... voids) {

            try {
                URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


            return null;
        }
    }
}
