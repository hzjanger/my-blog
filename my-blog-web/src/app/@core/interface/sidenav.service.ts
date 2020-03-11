import {Observable} from "rxjs";
import {SidenavMenu} from "../../model/sidenav-menu";

export abstract class SidenavService {
  /**
   * 获取侧边栏菜单目录
   */
  abstract getSidenav(): Observable<SidenavMenu[]>;
}
