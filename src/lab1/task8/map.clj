(ns lab1.task8.map)

(defn str-digits [s]
  (map #(Character/digit % 10) s))

(defn product [digits]
  (reduce * (str-digits digits)))

(defn find-max-product-map [digits]
  (->> digits
       (#(partition 13 1 %))
       (map product)
       (apply max)))