import { Component, OnInit } from '@angular/core';
import { Post1 } from '../post.model';
import { PostService } from '../post.service';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';

@Component({
	selector: 'app-post-myposts',
	templateUrl: './post-myposts.component.html',
	styleUrls: ['./post-myposts.component.css']
})
export class PostMypostsComponent implements OnInit {

	posts: Post1[] = [];
	constructor(private postService: PostService, private modalService: NgbModal) { }

	ngOnInit(): void {
		this.postService.getMyPosts()
			.subscribe(
				(posts: any[]): void => {
					this.posts = posts
				},
				(error) => console.log(error)
			);

	}
	onPostDelete(id: number) {

		this.postService.deletePost(id).subscribe(
			(newPost: any) => {
				window.location.reload();
			}
		)

	}
	refresh(): void {
		window.location.reload();
	}
	
	editPostId?:string ;
	editPostHeading: string = '';
	editPostBody: string = '';
	editPostDate: string = '';
	
	open(content: any, id: string, heading: string, body: string, date: string) {
		this.editPostId = id;
		this.editPostHeading = heading;
		this.editPostBody = body;
		this.editPostDate = date;
		
		this.modalService.open(content);
	};

	
	onPostEdit(id:string, heading: string, body: string, date: string) {
		let post: Post1 = new Post1(Number(id), sessionStorage.getItem('user') as string, heading, body, date);
		console.log(id);
		this.postService.addPost(post).subscribe(
			(newPost: any) => {
				this.postService.onPostAdded.emit(newPost);
				window.location.reload();
			}
		)

	}

}
