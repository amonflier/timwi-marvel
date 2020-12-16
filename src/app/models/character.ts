import { Thumbnail } from './thumbnail'

export class Character{
    id: number
    name: string
    thumbnail: Thumbnail
    description: string

    constructor(id: number, name: string, thumbnail: Thumbnail, description: string){
        this.id=id
        this.name=name
        this.thumbnail=thumbnail
        this.description=description
    }
}