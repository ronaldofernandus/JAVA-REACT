import Breadcrumb from '../components/Breadcrumbs/Breadcrumb';

import TableBarang from '../components/Tables/TabelBarang';

import DefaultLayout from '../layout/DefaultLayout';

const Tables = () => {
  return (
    <DefaultLayout>
      <Breadcrumb pageName="Tables" />

      <div className="flex flex-col gap-10">
      
        <TableBarang />
      </div>
    </DefaultLayout>
  );
};

export default Tables;
