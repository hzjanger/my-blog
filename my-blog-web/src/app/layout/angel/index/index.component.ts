import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {UserService} from "../../../@core/interface/user-service";
import {CodeEnum} from "../../../entity/code-enum";
import {User} from "../../../model/user";
import {SnackBarService} from "../../../service/snackBar.service";

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {

  /**
   * 昵称
   */
  nickName: string;

  /**
   * 用户信息
   */
  userInfo: User;

  constructor(private route: ActivatedRoute, private userService: UserService, private snackbarService: SnackBarService) {
  }

  ngOnInit() {
    this.nickName = this.route.snapshot.paramMap.get('nickName');
    this.findUserByNickname();
  }

  /**
   * 查询用户的信息
   */
  findUserByNickname() {
    this.userService.findUserByNickname(this.nickName).subscribe(data => {
      if (data.code === CodeEnum.SUCCESS) {
        this.userInfo = data.data;
      } else {
        this.snackbarService.failure(data.message);
      }
    })
  }

}
