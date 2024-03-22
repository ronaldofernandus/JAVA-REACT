import { useEffect, useState } from 'react';
import { Route, Routes, useLocation } from 'react-router-dom';

import Loader from './common/Loader';
import PageTitle from './components/PageTitle';

import FormElements from './pages/Form/FormInput';
import FormLayout from './pages/Form/FormUpdate';

import Tables from './pages/Tables';

import ECommerce from './pages/Dashboard/ECommerce';

function App() {
  const [loading, setLoading] = useState<boolean>(true);
  const { pathname } = useLocation();

  useEffect(() => {
    window.scrollTo(0, 0);
  }, [pathname]);

  useEffect(() => {
    setTimeout(() => setLoading(false), 1000);
  }, []);

  return loading ? (
    <Loader />
  ) : (
    <>
      <Routes>
        <Route
          index
          element={
            <>
              <PageTitle title="HOME" />
              <ECommerce />
            </>
          }
        />

        <Route
          path="/forms/form-input"
          element={
            <>
              <PageTitle title="Form INPUT" />
              <FormElements />
            </>
          }
        />

        <Route path="/forms/form-update">
          <Route path=":barang_id" element={<FormLayout />} />
        </Route>

        <Route
          path="/forms/form-update/:namaBarang"
          element={
            <>
              <PageTitle title="Update Form" />
              <FormLayout />
            </>
          }
        />

        <Route
          path="/tables"
          element={
            <>
              <PageTitle title="Table Product" />
              <Tables />
            </>
          }
        />
      </Routes>
    </>
  );
}

export default App;
