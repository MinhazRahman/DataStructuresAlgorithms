package linkedLists;

/** JavaScript code
 * class Node {
 *   constructor(val) {
 *     this.val = val;
 *     this.next = null;
 *   }
 * }
 *
 * const addLists = (head1, head2) => {
 *   let dummy = new Node();
 *   let tail = dummy;
 *   let carry = 0;
 *   let current1 = head1;
 *   let current2 = head2;
 *
 *   while(current1 != null || current2 != null){
 *     let p = current1 != null? current1.val: 0;
 *     let q = current2 != null? current2.val: 0;
 *
 *     let sum = p + q + carry;
 *     let value = sum % 10;
 *     carry = Math.trunc(sum/10);
 *
 *     let node = new Node(value);
 *     tail.next = node;
 *     tail = tail.next;
 *
 *     if(current1 != null) current1 = current1.next;
 *
 *     if(current2 != null) current2 = current2.next;
 *   }
 *
 *   if(carry > 0){
 *     let node = new Node(carry);
 *     tail.next = node;
 *   }
 *
 *   return dummy.next;
 * };
 *
 * 1 ----> 4 ----> 5 ----> 7
 * 2 ----> 3
 *
 * We can consider zeros for missing list values if one list is smaller than the other one
 * 1 ----> 4 ----> 5 ----> 7
 * 2 ----> 3 ----> 0 ----> 0
 *
 * */

/** JavaScript code
 * class Node {
 *   constructor(val) {
 *     this.val = val;
 *     this.next = null;
 *   }
 * }
 *
 * const addLists = (head1, head2) => {
 *   let dummy = new Node();
 *   let tail = dummy;
 *   let carry = 0;
 *   let current1 = head1;
 *   let current2 = head2;
 *
 *   while(current1 != null || current2 != null || carry > 0){
 *     let p = current1 != null? current1.val: 0;
 *     let q = current2 != null? current2.val: 0;
 *
 *     let sum = p + q + carry;
 *     let value = sum % 10;
 *     carry = Math.trunc(sum/10);
 *
 *     let node = new Node(value);
 *     tail.next = node;
 *     tail = tail.next;
 *
 *     if(current1 != null) current1 = current1.next;
 *     if(current2 != null) current2 = current2.next;
 *   }
 *
 *   return dummy.next;
 * };
 *
 * 1 ----> 4 ----> 5 ----> 7
 * 2 ----> 3
 *
 * We can consider zeros for missing list values if one list is smaller than the other one
 * 1 ----> 4 ----> 5 ----> 7
 * 2 ----> 3 ----> 0 ----> 0
 *
 * */

public class AddingLists {
}
