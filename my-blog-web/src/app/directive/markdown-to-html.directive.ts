import {AfterViewInit, Attribute, Directive, EventEmitter, Input, Output} from '@angular/core';

declare var editormd: any;

declare var $: any;

@Directive({
  selector: '[appMarkdownToHTML]'
})
export class MarkdownToHTMLDirective implements AfterViewInit {

  /**
   * editormd编辑器
   */
  editor: any;

  @Input()
  markdown: string;

  @Output()
  anchorPress: EventEmitter<string> = new EventEmitter<string>();

  constructor(@Attribute('id') private id: string, @Attribute("data-toggle") private toggle: string) {
  }

  ngAfterViewInit(): void {
    //可以调用editor中的方法
    this.editor = editormd.markdownToHTML(this.id, {
      markdown: this.markdown,//+ "\r\n" + $("#append-test").text(),
      //htmlDecode      : true,       // 开启 HTML 标签解析，为了安全性，默认不开启
      htmlDecode: "style,script,iframe",  // you can filter tags decode
      //toc             : false,
      tocm: true,    // Using [TOCM]
      tocContainer: `#${this.toggle}`, // 自定义 ToC 容器层
      //tocContainer    : "#custom-toc-container", // 自定义 ToC 容器层
      //gfm             : false,
      //tocDropdown     : true,
      // markdownSourceCode : true, // 是否保留 Markdown 源码，即是否删除保存源码的 Textarea 标签
      emoji: true,
      taskList: true,
      tex: true,  // 默认不解析
      flowChart: true,  // 默认不解析
      sequenceDiagram: true,  // 默认不解析
    }); // 创建编辑器


    // 通过事件委托发送点击事件
    document.querySelector(`#${this.toggle}`).addEventListener('click', (event: Event) => {
      const target: any = event.target || event.srcElement;
      if (target.nodeName.toLocaleLowerCase() === 'a') {
        target.removeAttribute("href");
        // this.anchorPress.emit(target.text);
        $("html, body").animate({
          scrollTop: $(`a[name=${target.text}`).offset().top - 70
        }, {duration: 500, easing: "swing"});
      }
    });
  }

}
