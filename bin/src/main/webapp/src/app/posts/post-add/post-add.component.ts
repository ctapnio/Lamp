import { Component, OnInit, ViewChild } from '@angular/core';
import { PostService } from '../post.service';
import { Post2 } from '../post.model';



@Component({
	selector: 'app-post-add',
	templateUrl: './post-add.component.html',
	styleUrls: ['./post-add.component.css']
})
export class PostAddComponent implements OnInit {

	
	addPostAuthor: string = '';
	addPostHeading: string = '';
	addPostBody: string = '';
	addPostDate: string = '';

	constructor(private postService: PostService) {

	}
	onPostAdd( heading: string, body: string, date: string) {
		let post: Post2 = new Post2( sessionStorage.getItem('user') as string, heading, body, date);

		this.postService.addPost(post).subscribe(
			(newPost: any) => {
				this.addPostAuthor = '';
				this.postService.onPostAdded.emit(newPost);
				window.location.reload();
			}
		)

	}
	refresh(): void {
		window.location.reload();
	}

	ngOnInit(): void {
	}


}
