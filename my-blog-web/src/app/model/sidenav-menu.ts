export interface SidenavMenu {
  /**
   * 图标地址
   */
  icon: string;

  /**
   * 标题
   */
  title: string;

  /**
   * 下级内容
   */
  children?: {

    /**
     * 标题名称
     */
    title: string;

    router: string;

    /**
     * 数量
     */
    account: number;
  }[];
}
