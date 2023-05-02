**Rule Engine**
=============

# Table of contents

## Description
A rule engine support sql/customized function on Java bean

### SQL Operator
    =, <>, >, <, >=, <=
    in, IN
    has, HAS
    like, LIKE
    and, AND
    or, OR
    true, TRUE
    false, FALSE
#### Example: (book = 'book_1' OR legalEntity = 'legal_2') AND assetClass = 'fx' AND roles has 'trader'

### Customized function
#### Example: toUpperCase(book) = 'BOOK_1' and toUpperCase('book') = 'BOOK' and book = 'book_1'