interface Post {
    id:  null | number | undefined;
	author: string;
	heading: string;
	body: string;
	date: Date;
}

export class Post1 implements Post{
	


	public constructor( id: number, author: string, heading:string, body:string, date: string) {
		this.id = id;
		this.author = author;
		this.heading = heading;
		this.body = body;
		this.date = new Date(date);

	}
    id: number ;
    author: string;
    heading: string;
    body: string;
    date: Date;
	
}

export class Post2 implements Post{
	


	public constructor( author: string, heading:string, body:string, date: string,) {
		this.author = author;
		this.heading = heading;
		this.body = body;
		this.date = new Date(date);

	}
    id: number | null | undefined;
    author: string;
	heading: string;
    body: string;
    date: Date;
	
}

