import React from 'react';
import './App.css';
import Header from '../header/Header';

const App: React.FC = ({children}) => {
  return (
    <div>
      <Header/>
      {children}
    </div>
  );
};

export default App;
