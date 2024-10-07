(ns lab1.task23.lazy)

(defn proper-divisors [n]
  (filter (fn [d] (zero? (mod n d)))
          (range 1 (inc (/ n 2)))))

(defn abundant? [n]
  (> (reduce + (proper-divisors n)) n))

(defn abundant-numbers []
  (filter abundant? (iterate inc 1)))

(def limit 28123)

(def abundant-nums (take-while #(< % 28124) (abundant-numbers)))

(defn sums-of-two-abundant []
  (let [abundant (vec abundant-nums)]
    (for [a abundant
          b abundant]
      (+ a b))))

(defn cannot-be-written-as-sum []
  (let [abundant-sums (into #{} (sums-of-two-abundant))
        all-nums (range 1 limit)]
    (filter #(not (abundant-sums %)) all-nums)))

(defn find-non-abundant-sum-lazy []
  (reduce + (cannot-be-written-as-sum)))

