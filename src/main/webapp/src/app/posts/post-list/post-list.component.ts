import { Component, OnInit } from '@angular/core';
import { Post1 } from '../post.model';
import { PostService } from '../post.service';

@Component({
	selector: 'app-post-list',
	templateUrl: './post-list.component.html',
	styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {

	posts: Post1[] = [];

	constructor(private postService: PostService) { }

	ngOnInit(): void {
		this.postService.getPost()
			.subscribe(
				(posts: any[]): void => {
					this.posts = posts
				},
				(error) => console.log(error)
			);
			
		this.postService.onPostAdded.subscribe(
			(post: Post1) => this.posts.push(post)
		);
	}
	
	search(keyword: string){
		this.postService.searchPost(keyword)
			.subscribe(
				(posts: any[]): void => {
					this.posts = posts
				},
				(error) => console.log(error)
			);
		
	}

}
