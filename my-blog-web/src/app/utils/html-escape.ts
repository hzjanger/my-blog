export class HtmlEscape {
  /**
   * markdown 注入脚本转义
   * @param markdown 需要转义的markdown字符串
   */
  public static htmlEncode(markdown: string) {
    let result = [];
    let arr = markdown.split('');
    // 为了arr[i+1]不溢出
    arr.push('');
    // flag 三个状态,example字符串: ```内容```, `内容`
    // start表示内容前面的`, center表示在`和`中间,end表示在内容后面
    let flag = 'start';
    for (let i = 0; i < arr.length - 1; i++) {
      if (arr[i] === '`') {
        result.push(arr[i]);
        if (flag === 'start' && arr[i + 1] === '`') {
          flag = 'start';
        } else if (flag === 'start' && arr[i + 1] !== '`') {
          flag = 'center';
        } else if (flag === 'center') {
          flag = 'end';
        } else if (flag === 'end' && arr[i + 1] === '`') {
          flag = 'end';
        } else if (flag === 'end' && arr[i + 1] !== '`') {
          flag = 'start';
        }
      } else if (arr[i] !== '`' && flag === 'start') {
        if (arr[i] === '<') {
          result.push('&lt;')
        } else if (arr[i] === '>') {
          result.push('&gt;')
        } else {
          result.push(arr[i]);
        }
      } else if (arr[i] !== '`' && flag === 'center') {
        result.push(arr[i]);
      }
    }
    return result.join('');
  }
}
