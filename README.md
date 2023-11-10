# graphql_with_spring
this is sample project with graphql spring boot
query allAuthors {
  authors: getAllAuthors {
    id
   ...nameFragment
    fullName
    books {
      id
      name
      pageCount
      publishYear
    }
  }
}

query getAuthorById($id:ID!, $include: Boolean!){
  getAuthorById(id:$id){
    id
    ...nameFragment
    books @include(if: $include){
      name
      pageCount
    }
  }
}

query getAuthorById1($id:ID!, $include: Boolean!){
  getAuthorById(id:$id){
    id
    ...nameFragment
    books @skip(if: $include){
      name
      pageCount
    }
  }
}

query healthCheck {
  health
}

fragment nameFragment on Author {
   firstName
   lastName
}


query allBooks {
  getAllBooks {
    id
    name
    pageCount
    author {
      id
      firstName
      lastName
      fullName
      books {
        name
      }
    }
  }
}

query healthCheck {
  health
}

query getBookById($id: ID!){
  getBookById(id: $id){
    id
    name
    pageCount
    publishYear
  }
}

query booksByid($id:[ID!]!){
  getBooksByIds(id:$id){
    id
    name
    publishYear
  }
}
