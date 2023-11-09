import { HttpClient, HttpHeaders } from "@angular/common/http";
import { EventEmitter, Injectable } from "@angular/core";
import { Post1 } from "./post.model";
import { Post2 } from "./post.model";

@Injectable()
export class PostService {
	constructor(private http: HttpClient) { }

	getPost() {
		const httpHeaders = new HttpHeaders({
			'Content-Type': 'application/json',
			'Accept': 'application/json',
			'Access-Control-Allow-Headers': 'Content-Type',
			'responseType': 'json',
			'Authorization': 'Bearer ' + sessionStorage.getItem('token')

		});

		return this.http.get<Post1[]>('/api/posts', { headers: httpHeaders })

	}
	searchPost(keyword: String) {

		const httpHeaders = new HttpHeaders({
			'Content-Type': 'application/json',
			'Accept': 'application/json',
			'Access-Control-Allow-Headers': 'Content-Type',
			'responseType': 'json',
			'Authorization': 'Bearer ' + sessionStorage.getItem('token')

		});
		if (keyword == null)
			return this.http.get<Post1[]>('/api/posts', { headers: httpHeaders })
		else
			return this.http.get<Post1[]>('/api/posts/search/' + keyword, { headers: httpHeaders })

	}
	getMyPosts() {
		const httpHeaders = new HttpHeaders({
			'Content-Type': 'application/json',
			'Accept': 'application/json',
			'Access-Control-Allow-Headers': 'Content-Type',
			'responseType': 'json',
			'Authorization': 'Bearer ' + sessionStorage.getItem('token')

		});

		return this.http.get<Post1[]>("/api/posts/myPosts/" + `${sessionStorage.getItem('user')}`, { headers: httpHeaders })

	}

	addPost(post: Post2) {
		return this.http.post('/api/posts', post);
	}

	editPost(post: Post2) {
		//continue
		return this.http.post('/api/posts/', post);
	}

	deletePost(id: number) {
		const httpHeaders = new HttpHeaders({
			'Content-Type': 'application/json',
			'Accept': 'application/json',
			'Access-Control-Allow-Headers': 'Content-Type',
			'responseType': 'json',
			'Authorization': 'Bearer ' + sessionStorage.getItem('token')

		});

		return this.http.post('/api/posts/delete/' + `${id}`, { headers: httpHeaders });
	}

	onPostAdded = new EventEmitter<Post1>();
}