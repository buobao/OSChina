package com.turman.oschina.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.turman.oschina.bean.base.Entity;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * 动弹实体类
 *
 * @author liux (http://my.oschina.net/liux),kymjs(kymjs123@gmail.com)
 * @version 1.1 添加语音动弹功能
 * @created 2012-3-21
 * @changed 2014-12-1
 */
@SuppressWarnings("serial")
@Root(name = "tweet")
@Default(value = DefaultType.FIELD,required = false)
public class Tweet extends Entity implements Parcelable {

    public String portrait;
    public String author;
    public int authorid;
    public String body;
    public int appclient;
    public String commentCount;
    public String pubDate;
    public String imgSmall;
    public String imgBig;
    public String attach;

    public int likeCount;

    public int isLike;

    public List<User> likeUser = new ArrayList<User>();

    public String imageFilePath;
    public String audioPath;

    public Tweet() {
    }

    public Tweet(Parcel dest) {
        id = dest.readInt();
        portrait = dest.readString();
        author = dest.readString();
        authorid = dest.readInt();
        body = dest.readString();
        appclient = dest.readInt();
        commentCount = dest.readString();
        pubDate = dest.readString();
        imgSmall = dest.readString();
        imgBig = dest.readString();
        attach = dest.readString();
        imageFilePath = dest.readString();
        audioPath = dest.readString();
        isLike = dest.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(portrait);
        dest.writeString(author);
        dest.writeInt(authorid);
        dest.writeString(body);
        dest.writeInt(appclient);
        dest.writeString(commentCount);
        dest.writeString(pubDate);
        dest.writeString(imgSmall);
        dest.writeString(imgBig);
        dest.writeString(attach);
        dest.writeString(imageFilePath);
        dest.writeString(audioPath);
        dest.writeInt(isLike);
    }

    public static final Creator<Tweet> CREATOR = new Creator<Tweet>() {

        @Override
        public Tweet[] newArray(int size) {
            return new Tweet[size];
        }

        @Override
        public Tweet createFromParcel(Parcel source) {
            return new Tweet(source);
        }
    };

//    public void setLikeUsers(Context contet, TextView likeUser, boolean limit) {
//        // 构造多个超链接的html, 通过选中的位置来获取用户名
//        if (this.likeCount > 0 && this.likeUser != null
//                && !this.likeUser.isEmpty()) {
//            likeUser.setVisibility(View.VISIBLE);
//            likeUser.setMovementMethod(LinkMovementMethod.getInstance());
//            likeUser.setFocusable(false);
//            likeUser.setLongClickable(false);
//            likeUser.setText(addClickablePart(contet, limit), BufferType.SPANNABLE);
//        } else {
//            likeUser.setVisibility(View.GONE);
//            likeUser.setText("");
//        }
//    }

    /**
     * @return
     */
//    private SpannableStringBuilder addClickablePart(final Context context,
//                                                    boolean limit) {
//
//        StringBuilder sbBuilder = new StringBuilder();
//        int showCunt = likeUser.size();
//        if (limit && showCunt > 4) {
//            showCunt = 4;
//        }
//
//        // 如果已经点赞，始终让该用户在首位
//        if (isLike == 1) {
//
//            for (int i = 0; i < likeUser.size(); i++) {
//                if (likeUser.get(i).id == AppContext.getInstance()
//                        .getLoginUid()) {
//                    likeUser.remove(i);
//                }
//            }
//            likeUser.add(0, AppContext.getInstance().getLoginUser());
//        }
//
//        for (int i = 0; i < showCunt; i++) {
//            sbBuilder.append(likeUser.get(i).name).append("、");
//        }
//
//        String likeUsersStr = sbBuilder.substring(0, sbBuilder.lastIndexOf("、"));
//
//        // 第一个赞图标
//        // ImageSpan span = new ImageSpan(AppContext.getInstance(),
//        // R.drawable.ic_unlike_small);
//        SpannableString spanStr = new SpannableString("");
//        // spanStr.setSpan(span, 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
//
//        SpannableStringBuilder ssb = new SpannableStringBuilder(spanStr);
//        ssb.append(likeUsersStr);
//
//        final String[] likeUsers = likeUsersStr.split("、");
//
//        if (likeUsers.length > 0) {
//            // 最后一个
//            for (int i = 0; i < likeUsers.length; i++) {
//                final String name = likeUsers[i];
//                final int start = likeUsersStr.indexOf(name) + spanStr.length();
//                final int index = i;
//                ssb.setSpan(new ClickableSpan() {
//                    @Override
//                    public void onClick(View widget) {
//                        User user = likeUsers.get(index);
//                        UIHelper.showUserCenter(context, user.getId(),
//                                user.name);
//                    }
//
//                    @Override
//                    public void updateDrawState(TextPaint ds) {
//                        super.updateDrawState(ds);
//                        // ds.setColor(R.color.link_color); // 设置文本颜色
//                        // 去掉下划线
//                        ds.setUnderlineText(false);
//                    }
//                }, start, start + name.length(), 0);
//            }
//        }
//        if (likeUsers.length < this.likeCount) {
//            ssb.append("等");
//            int start = ssb.length();
//            String more = this.likeCount + "人";
//            ssb.append(more);
//            ssb.setSpan(new ClickableSpan() {
//
//                @Override
//                public void onClick(View widget) {
//                    Bundle bundle = new Bundle();
//                    bundle.putInt(BaseListFragment.BUNDLE_KEY_CATALOG, getId());
//                    UIHelper.showSimpleBack(context,
//                            SimpleBackPage.TWEET_LIKE_USER_LIST, bundle);
//                }
//
//                @Override
//                public void updateDrawState(TextPaint ds) {
//                    super.updateDrawState(ds);
//                    // ds.setColor(R.color.link_color); // 设置文本颜色
//                    // 去掉下划线
//                    ds.setUnderlineText(false);
//                }
//
//            }, start, start + more.length(), 0);
//            return ssb.append("觉得很赞");
//        } else {
//            return ssb.append("觉得很赞");
//        }
//    }
}
