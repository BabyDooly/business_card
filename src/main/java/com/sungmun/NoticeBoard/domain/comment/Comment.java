//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.sungmun.NoticeBoard.domain.comment;

import com.sungmun.NoticeBoard.domain.BaseTimeEntity;
import com.sungmun.NoticeBoard.domain.member.Member;
import com.sungmun.NoticeBoard.domain.notice.Notice;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment extends BaseTimeEntity {
	@Id
	@GeneratedValue
	@Column(
			name = "comment_num",
			nullable = false
	)
	private Long num;
	@Column(
			name = "comment_contents",
			nullable = false
	)
	private String contents;
	@ManyToOne(
			fetch = FetchType.EAGER
	)
	@JoinColumn(
			name = "notice_id",
			nullable = false
	)
	private Notice notice;
	@ManyToOne(
			fetch = FetchType.EAGER
	)
	@JoinColumn(
			name = "member_id",
			nullable = false
	)
	private Member member;

	public static Comment.CommentBuilder builder() {
		return new Comment.CommentBuilder();
	}

	public Long getNum() {
		return this.num;
	}

	public String getContents() {
		return this.contents;
	}

	public Notice getNotice() {
		return this.notice;
	}

	public Member getMember() {
		return this.member;
	}

	public Comment(final Long num, final String contents, final Notice notice, final Member member) {
		this.num = num;
		this.contents = contents;
		this.notice = notice;
		this.member = member;
	}

	public String toString() {
		return "Comment(num=" + this.getNum() + ", contents=" + this.getContents() + ", notice=" + this.getNotice() + ", member=" + this.getMember() + ")";
	}

	protected Comment() {
	}

	public static class CommentBuilder {
		private Long num;
		private String contents;
		private Notice notice;
		private Member member;

		CommentBuilder() {
		}

		public Comment.CommentBuilder num(final Long num) {
			this.num = num;
			return this;
		}

		public Comment.CommentBuilder contents(final String contents) {
			this.contents = contents;
			return this;
		}

		public Comment.CommentBuilder notice(final Notice notice) {
			this.notice = notice;
			return this;
		}

		public Comment.CommentBuilder member(final Member member) {
			this.member = member;
			return this;
		}

		public Comment build() {
			return new Comment(this.num, this.contents, this.notice, this.member);
		}

		public String toString() {
			return "Comment.CommentBuilder(num=" + this.num + ", contents=" + this.contents + ", notice=" + this.notice + ", member=" + this.member + ")";
		}
	}
}
