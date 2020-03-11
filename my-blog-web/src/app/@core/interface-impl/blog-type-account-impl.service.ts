import {Injectable} from '@angular/core';
import {BlogTypeAccountService} from "../interface/blog-type-account.service";
import {Observable} from "rxjs";
import {ReturnModel} from "../../entity/return-model";
import {BlogTypeAccount} from "../../model/blog-type-account";
import {ProxyPrefix} from "../../entity/proxyPrefix";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class BlogTypeAccountImplService extends BlogTypeAccountService {

  private url: string = `${ProxyPrefix.api}/blogTypeAccount`;

  constructor(private http: HttpClient) {
    super();
  }

  findUserBlogTypeAccount(userId: number): Observable<ReturnModel<BlogTypeAccount[]>> {
    return this.http.get<ReturnModel<BlogTypeAccount[]>>(`${this.url}/findBlogTypeAccount/${userId}`);
  }
}
