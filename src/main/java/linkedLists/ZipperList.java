package linkedLists;
/**
 * Write a function, zipperLists, that takes in the head of two linked lists as arguments.
 * The function should zipper the two lists together into single linked list by alternating nodes.
 * If one of the linked lists is longer than the other, the resulting list should terminate with the remaining nodes.
 * The function should return the head of the zippered linked list.
 *
 * Do this in-place, by mutating the original Nodes.
 * You may assume that both input lists are non-empty.
 *
 * a -> b -> c
 * x -> y -> z
 * zipperLists(a, x) = a -> x -> b -> y -> c -> z
 *
 *  a -> b -> c -> d -> e -> f
 *  x -> y -> z
 *  zipperLists(a, x) = a -> x -> b -> y -> c -> z -> d -> e -> f
 *
 *  s -> t
 *  1 -> 2 -> 3 -> 4
 *  zipperLists(s, 1) = s -> 1 -> t -> 2 -> 3 -> 4
 *
 * */

public class ZipperList {
}
