### Java Native Interface

- Allows to invoke non-Java applications. If they are
not memory-safe, all bets are off.

- Not much that can be done there except detect and review.

- Foreign Function and Memory API provides simpler APIs but no
  security improvment.

Note: Best to use only memory-safe languages. But as of today most
drivers (JDBC and otherwise) are NOT written in such languages.
