package com.turman.oschina.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.turman.oschina.bean.base.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 评论实体类
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年10月14日 下午3:29:22
 *
 */
@SuppressWarnings("serial")
public class Comment extends Entity implements Parcelable {

	public static final String BUNDLE_KEY_COMMENT = "bundle_key_comment";
	public static final String BUNDLE_KEY_ID = "bundle_key_id";
	public static final String BUNDLE_KEY_CATALOG = "bundle_key_catalog";
	public static final String BUNDLE_KEY_BLOG = "bundle_key_blog";
	public static final String BUNDLE_KEY_OPERATION = "bundle_key_operation";
	
	public static final int OPT_ADD = 1;
	public static final int OPT_REMOVE = 2;
	
	public final static int CLIENT_MOBILE = 2;
	public final static int CLIENT_ANDROID = 3;
	public final static int CLIENT_IPHONE = 4;
	public final static int CLIENT_WINDOWS_PHONE = 5;

	public String portrait;
	public String content;
	public String author;
	public int authorId;
	public String pubDate;
	public int appClient;
	public List<Reply> replies = new ArrayList<Reply>();
	public List<Refer> refers = new ArrayList<Refer>();
	
	@SuppressWarnings("unchecked")
	public Comment(Parcel source) {
		id = source.readInt();
		portrait = source.readString();
		author = source.readString();
		authorId = source.readInt();
		pubDate = source.readString();
		appClient = source.readInt();
		content = source.readString();

		replies = source.readArrayList(Reply.class.getClassLoader());
		refers = source.readArrayList(Refer.class.getClassLoader());
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeString(portrait);
		dest.writeString(author);
		dest.writeInt(authorId);
		dest.writeString(pubDate);
		dest.writeInt(appClient);
		dest.writeString(content);

		dest.writeList(replies);
		dest.writeList(refers);
	}
	
	@Override
	public int describeContents() {
		return 0;
	}

	public static class Reply implements Serializable, Parcelable {
		public String rauthor;
		public String rpubDate;
		public String rcontent;
		
		public Reply() {
		}

		public Reply(Parcel source) {
			rauthor = source.readString();
			rpubDate = source.readString();
			rcontent = source.readString();
		}
		
		@Override
		public void writeToParcel(Parcel dest, int flags) {
			dest.writeString(rauthor);
			dest.writeString(rpubDate);
			dest.writeString(rcontent);
		}

		@Override
		public int describeContents() {
			return 0;
		}

		public static final Creator<Reply> CREATOR = new Creator<Reply>() {

			@Override
			public Reply[] newArray(int size) {
				return new Reply[size];
			}

			@Override
			public Reply createFromParcel(Parcel source) {
				return new Reply(source);
			}
		};

	}

	public static class Refer implements Serializable, Parcelable {
		public String refertitle;
		public String referbody;

		public Refer() {
		}

		public Refer(Parcel source) {
			referbody = source.readString();
			refertitle = source.readString();
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			dest.writeString(referbody);
			dest.writeString(refertitle);
		}

		@Override
		public int describeContents() {
			return 0;
		}

		public static final Creator<Refer> CREATOR = new Creator<Refer>() {

			@Override
			public Refer[] newArray(int size) {
				return new Refer[size];
			}

			@Override
			public Refer createFromParcel(Parcel source) {
				return new Refer(source);
			}
		};
	}

	public static final Creator<Comment> CREATOR = new Creator<Comment>() {

		@Override
		public Comment[] newArray(int size) {
			return new Comment[size];
		}

		@Override
		public Comment createFromParcel(Parcel source) {
			return new Comment(source);
		}
	};
}
